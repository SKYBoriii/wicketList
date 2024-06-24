package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BucketListDTO {

    private Long id;
    private String bucketGoal;
    private String bucketContent;



    private String completedAt;  // yyyy/mm/dd

    public BucketListDTO(Long id, String bucketGoal, String bucketContent, String bucketCompletAt) {
        this.id = id;
        this.bucketGoal = bucketGoal;
        this.bucketContent = bucketContent;
        this.completedAt = bucketCompletAt;
    }


}
