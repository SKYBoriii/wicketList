package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishListResponseDTO {

    private Long id;
    private String wishWriter;
    private String wishContent;

    public WishListResponseDTO(Long id, String wishWriter, String wishContent) {
        this.id = id;
        this.wishWriter = wishWriter;
        this.wishContent = wishContent;
    }


}
