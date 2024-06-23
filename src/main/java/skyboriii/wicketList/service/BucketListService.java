package skyboriii.wicketList.service;

import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.data.dto.BucketListResponseDTO;

public interface BucketListService {

    BucketListResponseDTO getBucketList(Long id);

    BucketListResponseDTO saveBucketList(BucketListDTO bucketListDTO);

    BucketListResponseDTO changeBucketListContent(Long id, String content) throws Exception;

    void deleteBucketList(Long id) throws Exception;
}
