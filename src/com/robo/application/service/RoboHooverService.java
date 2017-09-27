package com.robo.application.service;

import com.robo.application.domain.model.RoboHoover;
import com.robo.application.domain.model.Room;
import com.robo.application.exception.RoboHooverException;
import com.robo.application.utils.RoboHooverConstants;
import com.robo.application.vo.RoboHooverInputsVO;
import com.robo.application.web.rest.dto.request.RoboHooverRequest;
import com.robo.application.web.rest.dto.response.RoboHooverError;
import com.robo.application.web.rest.dto.response.RoboHooverResponse;
import com.robo.application.utils.RoboHooverUtils;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;


import java.awt.*;
import java.util.Arrays;

@Service
public class RoboHooverService implements IRoboHooverService {

    @Override
    public RoboHooverResponse runCleaning(RoboHooverRequest roboHooverReq) throws RoboHooverException {
        if(null != roboHooverReq) {
            //validate_inputs
            RoboHooverInputsVO inputsVO = new RoboHooverUtils().validateInputs(roboHooverReq);
            //init_room
            Room room = new Room(inputsVO.getRoomSize(), inputsVO.getPatchesPosition());
            //init_hoover
            RoboHoover hoover = new RoboHoover(inputsVO.getHooverInitialPosition(), room);
            //move_hoover
            hoover.executeCommands(inputsVO.getCommands());
            //display_results
            final Point finalHooverPosition = hoover.hooverPosition();
            return new RoboHooverResponse(
                    new int[] {finalHooverPosition.x, finalHooverPosition.y},
                    room.getStainRemovalCount(),
                    null);
        }
        return new RoboHooverResponse(null,
                0,
                Arrays.asList(new RoboHooverError(
                        false,
                        RoboHooverConstants.ERROR_INPUT_SERVICE,
                        "")));
    }

}
