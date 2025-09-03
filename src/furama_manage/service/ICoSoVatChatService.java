package furama_manage.service;

import furama_manage.entity.CoSoVatChat;

import java.util.Map;

public interface ICoSoVatChatService {
    Map<CoSoVatChat, Integer> displayAllFacility();
    void addFacility();
    Map<CoSoVatChat, Integer> displayFacilityMaintenance();
}
