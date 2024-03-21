package ezenweb.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;

@Entity
@Table(name="salesproject")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //auto_increment
    private int spjno;//pk
    @Column(nullable = false, columnDefinition = "date")
    private Date start_date;
    @Column(nullable = false, columnDefinition = "date")
    private Date end_date;
    @Column(nullable = true)
    private int rank1_count;
    @Column(nullable = true)
    private int rank2_count;
    @Column(nullable = true)
    private int rank3_count;
    @Column(nullable = false, length=30)
    private String title;
    @Column(nullable = true)
    private String request;
    private String note;
    @Column(nullable = false, length = 20)
    private String compannyname;
    @ColumnDefault("-1")
    private int state;
    @Column(nullable = false)
    private int price;
}
