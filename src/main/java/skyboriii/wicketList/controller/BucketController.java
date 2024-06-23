package skyboriii.wicketList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.data.dto.BucketListResponseDTO;
import skyboriii.wicketList.data.dto.ChangeBucketListContentDTO;
import skyboriii.wicketList.service.BucketListService;

@RestController
@RequestMapping("/buk")
public class BucketController {

    private final BucketListService bucketListService;

    @Autowired
    public BucketController(BucketListService bucketListService) {
        this.bucketListService = bucketListService;
    }

    @GetMapping()
    public ResponseEntity<BucketListResponseDTO> getBucket(Long id) {
        BucketListResponseDTO bucketListResponseDTO = bucketListService.getBucketList(id);

        return ResponseEntity.status(HttpStatus.OK).body(bucketListResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<BucketListResponseDTO>
            createBucketList(@RequestBody BucketListDTO bucketListDTO){
        BucketListResponseDTO bucketListResponseDTO = bucketListService.saveBucketList(bucketListDTO);

        return ResponseEntity.status(HttpStatus.OK).body(bucketListResponseDTO);
    }

    @PutMapping
    public ResponseEntity<BucketListResponseDTO> changeBucketlistContent(
            @RequestBody ChangeBucketListContentDTO changeBucketListContentDTO) throws Exception {
        BucketListResponseDTO bucketListResponseDTO = bucketListService.changeBucketListContent(

                changeBucketListContentDTO.getId(),
                changeBucketListContentDTO.getBucketContent()
        );

        return ResponseEntity.status(HttpStatus.OK).body(bucketListResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBucketList(Long id) throws Exception {
        bucketListService.deleteBucketList(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제됨");
    }
}
