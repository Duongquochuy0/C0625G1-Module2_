package furama_manage.repository;

import furama_manage.entity.CoSoVatChat;

import java.util.Map;

public interface ICoSoVatChatRepository {
    Map<CoSoVatChat, Integer> getAllFacilities();
    void addFacility(CoSoVatChat facility);
    Map<CoSoVatChat, Integer> getFacilitiesForMaintenance();
//    void updateFacilityUsage(String facilityId);
}
