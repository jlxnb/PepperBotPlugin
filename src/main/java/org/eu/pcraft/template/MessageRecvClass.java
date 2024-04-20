package org.eu.pcraft.template;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class MessageRecvClass {
    @SerializedName("CurrentPacket")
    public CurrentPacketDTO currentPacket;
    @SerializedName("CurrentQQ")
    public Long currentQQ;

    @NoArgsConstructor
    @Data
    public static class CurrentPacketDTO {
        @SerializedName("EventData")
        public EventDataDTO eventData;
        @SerializedName("EventName")
        public String eventName;

        @NoArgsConstructor
        @Data
        public static class EventDataDTO {
            @SerializedName("MsgHead")
            public MsgHeadDTO msgHead;
            @SerializedName("MsgBody")
            public MsgBodyDTO msgBody;
            @SerializedName("Event")
            public Object event;

            @NoArgsConstructor
            @Data
            public static class MsgHeadDTO {
                @SerializedName("FromUin")
                public Long fromUin;
                @SerializedName("FromUid")
                public String fromUid;
                @SerializedName("ToUin")
                public Long toUin;
                @SerializedName("ToUid")
                public String toUid;
                @SerializedName("FromType")
                public Long fromType;
                @SerializedName("SenderUin")
                public Long senderUin;
                @SerializedName("SenderUid")
                public String senderUid;
                @SerializedName("SenderNick")
                public String senderNick;
                @SerializedName("MsgType")
                public Integer msgType;
                @SerializedName("C2cCmd")
                public Long c2cCmd;
                @SerializedName("MsgSeq")
                public Long msgSeq;
                @SerializedName("MsgTime")
                public Long msgTime;
                @SerializedName("MsgRandom")
                public Long msgRandom;
                @SerializedName("MsgUid")
                public Long msgUid;
                @SerializedName("GroupInfo")
                public GroupInfoDTO groupInfo;
                @SerializedName("C2CTempMessageHead")
                public Object c2CTempMessageHead;

                @NoArgsConstructor
                @Data
                public static class GroupInfoDTO {
                    @SerializedName("GroupCard")
                    public String groupCard;
                    @SerializedName("GroupCode")
                    public Long groupCode;
                    @SerializedName("GroupInfoSeq")
                    public Long groupInfoSeq;
                    @SerializedName("GroupLevel")
                    public Long groupLevel;
                    @SerializedName("GroupRank")
                    public Long groupRank;
                    @SerializedName("GroupType")
                    public Long groupType;
                    @SerializedName("GroupName")
                    public String groupName;
                }
            }

            @NoArgsConstructor
            @Data
            public static class MsgBodyDTO {
                @SerializedName("SubMsgType")
                public Long subMsgType;
                @SerializedName("Content")
                public String content;
                @SerializedName("AtUinLists")
                public List<AtUinListsDTO> atUinLists;
                @SerializedName("Images")
                public List<ImagesDTO> images;
                @SerializedName("Video")
                public Object video;
                @SerializedName("Voice")
                public Object voice;
                @SerializedName("RedBag")
                public Object redBag;

                @NoArgsConstructor
                @Data
                public static class AtUinListsDTO {
                    @SerializedName("Nick")
                    public String nick;
                    @SerializedName("Uid")
                    public String uid;
                    @SerializedName("Uin")
                    public Long uin;
                }

                @NoArgsConstructor
                @Data
                public static class ImagesDTO {
                    @SerializedName("FileId")
                    public Long fileId;
                    @SerializedName("FileMd5")
                    public String fileMd5;
                    @SerializedName("FileSize")
                    public Long fileSize;
                    @SerializedName("Url")
                    public String url;
                }
            }
        }
    }
}
