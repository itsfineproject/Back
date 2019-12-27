package itsfine.com.back.mappers;

import itsfine.com.back.documents.AppErrorDoc;
import itsfine.com.back.documents.InvalidCarDataDoc;
import itsfine.com.back.dtos.AppError;
import itsfine.com.back.dtos.InvalidCarData;

public class AppErrorMapper extends AbstractMapper<AppErrorDoc, AppError>{
    public AppErrorMapper(Class<AppErrorDoc> entityClass, Class<AppError> dtoClass) {
        super(entityClass, dtoClass);
    }
}
