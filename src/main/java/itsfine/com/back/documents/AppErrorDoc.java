package itsfine.com.back.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Document(collection = "applogs")
public class AppErrorDoc {

    @Id
    private ObjectId _id;
    private LocalDateTime dateTime;
    private String errorMessage;
    private String errorSource;

    public AppErrorDoc(LocalDateTime dateTime, String errorMessage, String errorSource) {
        this.dateTime = dateTime;
        this.errorMessage = errorMessage;
        this.errorSource = errorSource;
    }
}
