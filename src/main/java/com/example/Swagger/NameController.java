package com.example.Swagger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NameController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "name", content =
                    {
                            @Content(mediaType = "application/string")
                    })
    })

    @Operation(summary = "method name")
    @GetMapping(path = "/getName")
    public String name(@Parameter(description = "User's name request paramater") @RequestParam(value = "nome", required = true) String nome) {
        return nome;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " reverse name", content =
                    {
                            @Content(mediaType = "application/string")
                    })
    })


    @Operation(summary = "reverse name")
    @PostMapping(path = "/getReverseName")
    public String reverseName(@Parameter(description = "User's reverse name parameter") @RequestParam(value = "name", required = true) String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
