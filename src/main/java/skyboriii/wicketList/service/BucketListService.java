package skyboriii.wicketList.service;

import skyboriii.wicketList.data.dto.BucketListDTO;

public interface BucketListService {

    // 호출
    BucketListDTO getBucketList(Long id);

    // 저장
    BucketListDTO saveBucketList(BucketListDTO bucketListDTO);

    // 변경
    BucketListDTO changeBucketListContent(Long id, String content, String goal, String completedAt) throws Exception;

    BucketListDTO completedBucketAt(Long id, String completedAt) throws Exception;

    // 삭제
    void deleteBucketList(Long id) throws Exception;

}
