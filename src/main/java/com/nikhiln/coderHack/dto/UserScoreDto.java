package com.nikhiln.coderHack.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserScoreDto {

    @Min(value = 0, message = "Score should not be less than 0")
    @Max(value = 100, message = "Score should not be greater than 100")
    private int score;

}
