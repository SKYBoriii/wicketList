package skyboriii.wicketList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.data.dto.ChangeBucketListContentDTO;
import skyboriii.wicketList.service.BucketListService;

@RestController
@RequestMapping("/bucket")
public class BucketController {

    private final BucketListService bucketListService;

    @Autowired
    public BucketController(BucketListService bucketListService) {
        this.bucketListService = bucketListService;
    }

    @GetMapping()
    public ResponseEntity<BucketListDTO> getBucket(Long id) {
        BucketListDTO bucketListDTO = bucketListService.getBucketList(id);

        return ResponseEntity.status(HttpStatus.OK).body(bucketListDTO);
    }

    @PostMapping()
    public ResponseEntity<BucketListDTO>
            createBucketList(@RequestBody BucketListDTO bucketListDTO){
        BucketListDTO bucketListResponseDTO = bucketListService.saveBucketList(bucketListDTO);

        return ResponseEntity.status(HttpStatus.OK).body(bucketListResponseDTO);
    }

    @PutMapping
    public ResponseEntity<BucketListDTO> changeBucketlistContent(
            @RequestBody BucketListDTO changeBucketListContentDTO) throws Exception {
        BucketListDTO bucketListDTO = bucketListService.changeBucketListContent(

                changeBucketListContentDTO.getId(),
                changeBucketListContentDTO.getBucketContent(),
                changeBucketListContentDTO.getBucketGoal(),
                changeBucketListContentDTO.getCompletedAt()

        );

        return ResponseEntity.status(HttpStatus.OK).body(bucketListDTO);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBucketList(Long id) throws Exception {
        bucketListService.deleteBucketList(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제됨");
    }
}
