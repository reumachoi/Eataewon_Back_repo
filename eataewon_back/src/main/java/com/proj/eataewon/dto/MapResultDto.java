package com.proj.eataewon.dto;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class MapResultDto {
    private String shopname;
    private String address;
    private String shopphnum;
    private String shopurl;
    private Double longitude;
    private Double latitude;
}

