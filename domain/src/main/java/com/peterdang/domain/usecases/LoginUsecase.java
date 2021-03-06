package com.peterdang.domain.usecases;

import com.example.entities.response.BaseResponse;
import com.example.entities.response.LoginModel;
import com.peterdang.domain.QueryUseCase;
import com.example.repositories.UserRepository;
import com.peterdang.domain.exceptions.DataEntityException;
import com.peterdang.domain.utils.ValidateUtils;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by phuoc on 2017-10-17.
 */

public class LoginUsecase extends QueryUseCase<BaseResponse<LoginModel>,LoginUsecase.LoginParam> {

    private final UserRepository mRepository;

    public LoginUsecase(Scheduler workScheduler, Scheduler observeScheduler, UserRepository userRepository) {
        super(workScheduler, observeScheduler);
        mRepository = userRepository;
    }

    @Override
    protected Observable<BaseResponse<LoginModel>> buildUseCaseObservable(LoginParam loginParam) {

        return mRepository.login(loginParam.username, loginParam.password);
    }

    public static class LoginParam {
        String username, password;

        public LoginParam(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean isValid() throws DataEntityException {
            if(ValidateUtils.isEmpty(username)){
                throw new DataEntityException("username can not be empty");
            }
            if(ValidateUtils.isEmpty(password)){
                throw new DataEntityException("password can not be empty");
            }
            return true;
        }
    }
}
