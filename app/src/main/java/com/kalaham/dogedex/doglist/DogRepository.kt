package com.kalaham.dogedex.doglist

import com.kalaham.dogedex.Dog
import com.kalaham.dogedex.api.DogsApi.retrofitService
import com.kalaham.dogedex.api.dto.DogDTOMapper
import com.kalaham.dogedex.api.makeNetworkCall
import com.kalaham.dogedex.api.responses.ApiResponseStatus

class DogRepository {

    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)

    }

}