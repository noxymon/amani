package id.akademi.amani.courses.services.models;

import lombok.Getter;

@Getter
public class MeetingDetailResponse {
    public String uuid;
    public String id;
    public String hostId;
    public String topic;
    public Integer type;
    public String status;
    public String timezone;
    public String agenda;
    public String createdAt;
    public String startUrl;
    public String joinUrl;
    public String password;
    public String h323Password;
    public String pstnPassword;
    public String encryptedPassword;
    public Settings settings;

    @Getter
    public class Settings {
        public Boolean hostVideo;
        public Boolean participantVideo;
        public Boolean cnMeeting;
        public Boolean inMeeting;
        public Boolean joinBeforeHost;
        public Boolean muteUponEntry;
        public Boolean watermark;
        public Boolean usePmi;
        public Integer approvalType;
        public String audio;
        public String autoRecording;
        public Boolean enforceLogin;
        public String enforceLoginDomains;
        public String alternativeHosts;
        public Boolean closeRegistration;
        public Boolean registrantsConfirmationEmail;
        public Boolean waitingRoom;
        public Boolean requestPermissionToUnmuteParticipants;
        public Boolean registrantsEmailNotification;
        public Boolean meetingAuthentication;
    }
}