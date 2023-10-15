package reqres.models;

import lombok.Data;

@Data
public class DeleteBookModel {
    String isbn, userId;
}