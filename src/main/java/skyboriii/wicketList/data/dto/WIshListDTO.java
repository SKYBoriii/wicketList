package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WIshListDTO {

    private String wishWriter;
    private String wishContent;


    public WIshListDTO(String wishWriter, String wishContent) {
        this.wishWriter = wishWriter;
        this.wishContent = wishContent;
    }
}
