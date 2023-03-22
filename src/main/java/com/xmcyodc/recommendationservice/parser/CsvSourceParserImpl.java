package com.xmcyodc.recommendationservice.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.xmcyodc.recommendationservice.exception.CsvParserException;
import com.xmcyodc.recommendationservice.model.csv.CryptocurrencyCsvBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CsvSourceParserImpl implements CsvSourceParser {

    private static final String STATIC_CSV = "static/csv";

    @Override
    public List<CryptocurrencyCsvBean> parseAll() {
        File scrDirectory = urlToFile(findCsvDirectoryUrl(STATIC_CSV));
        final List<CryptocurrencyCsvBean> result = new ArrayList<>();
        Stream.of(scrDirectory.listFiles()).forEach(file -> {
            try (Reader reader = Files.newBufferedReader(file.toPath())) {
                CsvToBean<CryptocurrencyCsvBean> cb = new CsvToBeanBuilder<CryptocurrencyCsvBean>(reader)
                        .withType(CryptocurrencyCsvBean.class)
                        .build();
                result.addAll(cb.parse());
            } catch (IOException e) {
                throw new CsvParserException("File " + file.getName() + "cannot be parsed");
            }
        });
        return result;
    }

    private File urlToFile(URL resource) {
        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new CsvParserException("Internal error with csv directory. Please, check the source file");
        }
    }

    private URL findCsvDirectoryUrl(String directoryPath) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(directoryPath);
        if (resource == null) {
            throw new CsvParserException("file not found! " + directoryPath);
        }
        return resource;
    }

}
