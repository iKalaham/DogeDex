package com.kalaham.dogedex.doglist

import com.kalaham.dogedex.Dog
import com.kalaham.dogedex.api.DogsApi.retrofitService
import com.kalaham.dogedex.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs(): List<Dog>{
        return withContext(Dispatchers.IO){
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)

        }
    }

}