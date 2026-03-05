package jaz_29093_nbp.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jaz_29093_nbp.Query.Query;
import jaz_29093_nbp.Query.QueryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
@Tag(name = "Rates NBP", description = "Operations on the rates from NBP")
public class RestControllerSi {

    private final QueryService queryService;

    public RestControllerSi(QueryService queryService) {
        this.queryService = queryService;
    }

    @Operation(
            summary = "Avarage rate of the currency",
            description = "Returns the average rate for the specific currency in the selected days"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Average rate has been calculated"),
            @ApiResponse(responseCode = "400", description = "Incorrect parameters")
    })
    @GetMapping("/average")
    public ResponseEntity<Query> getAverageRate(
            @RequestParam String currency,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        Query query = queryService.calculateAverageRate(currency, startDate, endDate);
        return ResponseEntity.ok(query);
    }
}
