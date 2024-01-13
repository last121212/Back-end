package com.mavidev.dto.request;




import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddLocationDto {
    @Pattern(regexp="^[a-zA-ZçÇğĞıİöÖşŞüÜ]+$",message = "Lütfen sadece harf giriniz.")
    private String cityName;
    @Pattern(regexp="^[a-zA-ZçÇğĞıİöÖşŞüÜ]+$",message = "Lütfen sadece harf giriniz.")
    private String countyName;
}
