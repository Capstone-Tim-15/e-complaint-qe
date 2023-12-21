package starter;

public class Url {

    public static final String baseUrl = "http://34.128.69.15:8000/";



    public static final String userUrl = baseUrl + "user/";
    public static final String adminUrl = baseUrl + "admin/";

    //USER
    public static final String userRegistUrl = userUrl + "register";
    public static final String userLoginUrl = userUrl + "login";
    public static final String userComplaintUrl = userUrl + "complaint";
    public static final String userCreateRoomChatUrl = baseUrl + "chat/user/ws/create-room";
    public static final String userGetChatByRoomIdUrl = baseUrl + "chat/user/ws/get-chats/{room_id}";
    public static final String invChatRoomUrl = baseUrl + "chat/users/ws/get-chats/{room_id}";
    public static final String userFaqUrl = userUrl + "faq";
    public static final String userSendOtpUrl = baseUrl + "otp/user/send-otp";
    public static final String userCategoryUrl = userUrl + "category";






    //ADMIN
    public static final String adminRegistUrl = adminUrl + "register";
    public static final String adminLoginUrl = adminUrl + "login";
    public static final String adminSendOtpUrl = baseUrl + "otp/admin/send-otp";
    public static final String adminLandingUrl = adminUrl + "landing";

    public static final String adminComplaintStatUrl = adminUrl + "dashboard/complaint";
    public static final String adminSolvedStatUrl = adminUrl + "dashboard/solved";
    public static final String adminUserStatUrl = adminUrl + "dashboard/user";
    public static final String adminNotifUrl = adminUrl + "notification";



    //INVALID
    public static String invUrl = baseUrl + "users";



}
