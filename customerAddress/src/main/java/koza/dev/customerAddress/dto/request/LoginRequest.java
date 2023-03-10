package koza.dev.customerAddress.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
