package skyboriii.wicketList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyboriii.wicketList.data.dto.ChangeWishListContentDTO;
import skyboriii.wicketList.data.dto.WIshListDTO;
import skyboriii.wicketList.data.dto.WishListResponseDTO;
import skyboriii.wicketList.service.WIshListService;

@RestController
@RequestMapping("/wish")
public class WishController {

    private final WIshListService wishListService;

    @Autowired
    public WishController(WIshListService wIshListService) {
        this.wishListService = wIshListService;
    }

    @GetMapping()
    public ResponseEntity<WishListResponseDTO> getWishList(@RequestParam Long id){
        WishListResponseDTO wishListResponseDTO = wishListService.getWishList(id);

        return ResponseEntity.status(HttpStatus.OK).body(wishListResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<WishListResponseDTO> createWishList (@RequestBody WIshListDTO wIshListDTO) {
        WishListResponseDTO wishListResponseDTO = wishListService.saveWishList(wIshListDTO);

        return ResponseEntity.status(HttpStatus.OK).body(wishListResponseDTO);
    }

    @PutMapping()
    public ResponseEntity<WishListResponseDTO> changeWishListName(
            @RequestBody ChangeWishListContentDTO changeWishListContentDTO) throws Exception {
        WishListResponseDTO wishListResponseDTO = wishListService.changeWishListContent(
                changeWishListContentDTO.getId(),
                changeWishListContentDTO.getWishContent());

        return ResponseEntity.status(HttpStatus.OK).body(wishListResponseDTO);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteWishList(Long id) throws Exception {
        wishListService.deleteWishList(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제된");
    }

}



