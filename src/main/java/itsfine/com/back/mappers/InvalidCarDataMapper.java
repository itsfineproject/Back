package itsfine.com.back.mappers;

import itsfine.com.back.documents.InvalidCarDataDoc;
import itsfine.com.back.dtos.InvalidCarData;

public class InvalidCarDataMapper extends AbstractMapper<InvalidCarDataDoc, InvalidCarData>{
    public InvalidCarDataMapper(Class<InvalidCarDataDoc> entityClass, Class<InvalidCarData> dtoClass) {
        super(entityClass, dtoClass);
    }
}
