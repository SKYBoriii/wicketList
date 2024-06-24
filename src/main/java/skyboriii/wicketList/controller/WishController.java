package skyboriii.wicketList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyboriii.wicketList.data.dto.ChangeWishListContentDTO;
import skyboriii.wicketList.data.dto.WishListDTO;
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
    public ResponseEntity<WishListDTO> getWishList(@RequestParam Long id){
        WishListDTO wishListDTO = wishListService.getWishList(id);

        return ResponseEntity.status(HttpStatus.OK).body(wishListDTO);
    }

    @PostMapping()
    public ResponseEntity<WishListDTO> createWishList (@RequestBody WishListDTO wishListDto) {
        WishListDTO wishListDTO = wishListService.saveWishList(wishListDto);

        return ResponseEntity.status(HttpStatus.OK).body(wishListDTO);
    }

    @PutMapping()
    public ResponseEntity<WishListDTO> changeWishListName(
            @RequestBody ChangeWishListContentDTO changeWishListContentDTO) throws Exception {
        WishListDTO wishListDTO = wishListService.changeWishListItem(
                changeWishListContentDTO.getId(),
                changeWishListContentDTO.getWishItem(),
                changeWishListContentDTO.getWishPrice()

                );

        return ResponseEntity.status(HttpStatus.OK).body(wishListDTO);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteWishList(Long id) throws Exception {
        wishListService.deleteWishList(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제된");
    }

}



