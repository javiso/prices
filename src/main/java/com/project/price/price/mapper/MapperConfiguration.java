package com.project.price.price.mapper;

import com.project.price.price.dto.PriceApi;
import com.project.price.price.model.Price;
import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class MapperConfiguration implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(@NotNull MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Price.class, PriceApi.class).field("brand.id", "brandId").byDefault().register();
    }
}
