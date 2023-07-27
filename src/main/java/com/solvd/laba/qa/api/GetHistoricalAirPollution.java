package com.solvd.laba.qa.api;

import com.solvd.laba.qa.configuration.WeatherProperties;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

@Endpoint(url = "${base_url}/${data_ver}/air_pollution/history?lat=${lat}&lon=${lon}&start=${start}&end=${end}&appid=${api_key}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api_weather/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetHistoricalAirPollution extends AbstractApiMethodV2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public GetHistoricalAirPollution() {
        Properties properties = WeatherProperties.getProperties();

        replaceUrlPlaceholder("base_url", Configuration.getRequired("base_url"));
        replaceUrlPlaceholder("data_ver", Configuration.getRequired("data_ver"));
        replaceUrlPlaceholder("api_key", Configuration.getRequired("key"));
        replaceUrlPlaceholder("lat", properties.getProperty("lat"));
        replaceUrlPlaceholder("lon", properties.getProperty("lon"));
        replaceUrlPlaceholder("start", properties.getProperty("start"));
        replaceUrlPlaceholder("end", properties.getProperty("end"));
        LOGGER.info("URL placeholder replacement successful");
    }

}
