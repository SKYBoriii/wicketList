package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeWishListContentDTO {

    private Long id;
    private String wishContent;

    public ChangeWishListContentDTO(Long id, String wishContent) {
        this.id = id;
        this.wishContent = wishContent;
    }
}
