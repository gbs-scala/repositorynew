package com.robo.application.service;

import com.robo.application.exception.RoboHooverException;
import com.robo.application.web.rest.dto.request.RoboHooverRequest;
import com.robo.application.web.rest.dto.response.RoboHooverResponse;

public interface IRoboHooverService {

    public RoboHooverResponse runCleaning(RoboHooverRequest roboHooverReq) throws RoboHooverException;

}
