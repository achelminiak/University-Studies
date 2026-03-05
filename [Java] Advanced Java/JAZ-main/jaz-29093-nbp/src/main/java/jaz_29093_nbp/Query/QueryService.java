package jaz_29093_nbp.Query;

import jaz_29093_nbp.Repository.QueryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class QueryService {

    private final QueryRepository queryRepository;
    private final RestTemplate restTemplate;

    public QueryService(QueryRepository queryRepository, RestTemplate restTemplate) {
        this.queryRepository = queryRepository;
        this.restTemplate = restTemplate;
    }

    public Query calculateAverageRate(String currency, LocalDate startDate, LocalDate endDate) {
        String url = String.format(
                "https://api.nbp.pl/api/exchangerates/rates/A/%s/%s/%s/?format=json",
                currency, startDate, endDate
        );

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        List<Map<String, Object>> rates = (List<Map<String, Object>>) response.get("rates");

        if (rates == null || rates.isEmpty()) {
            throw new RuntimeException("No rates received");
        }

        double sum = 0;
        for (Map<String, Object> rate : rates) {
            Number mid = (Number) rate.get("mid");
            if (mid != null) {
                sum += mid.doubleValue();
            }
        }
        double average = sum / rates.size();

        Query query = new Query();
        query.setCurrency(currency);
        query.setStartDate(startDate);
        query.setEndDate(endDate);
        query.setAverageRate(average);
        query.setCurrentTime(LocalDateTime.now());

        return queryRepository.save(query);
    }

}
