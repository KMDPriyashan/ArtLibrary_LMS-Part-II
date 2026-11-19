package Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class BookEntity {

    @Id
    private String book_id;
    private String title;
    private String author;
    private String category;
    private int published_year;
    private int quantity;
}
