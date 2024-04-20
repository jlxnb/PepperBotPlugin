package org.eu.pcraft.template;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class MessageSendClass {
    @SerializedName("CgiCmd")
    public String cgiCmd="MessageSvc.PbSendMsg";
    @SerializedName("CgiRequest")
    public CgiRequestDTO cgiRequest=new CgiRequestDTO();

    @NoArgsConstructor
    @Data
    public static class CgiRequestDTO {
        @SerializedName("ToUin")
        public Long toUin;
        @SerializedName("ToType")
        public int toType;
        @SerializedName("Content")
        public String content;
        @SerializedName("AtUinLists")
        public List<AtUinListsDTO> atUinLists=new ArrayList<>();
        @SerializedName("Images")
        public List<ImagesDTO> images=new ArrayList<>();
        @SerializedName("Voice")
        public VoiceDTO voice;

        @NoArgsConstructor
        @Data
        public static class VoiceDTO {
            @SerializedName("FileMd5")
            public String fileMd5;
            @SerializedName("FileSize")
            public int fileSize;
            @SerializedName("FileToken")
            public String fileToken;
        }

        @NoArgsConstructor
        @Data
        public static class AtUinListsDTO {
            public AtUinListsDTO(Long uin, String nick){
                this.uin=uin;
                this.nick=nick;
            }
            @SerializedName("Uin")
            public Long uin;
            @SerializedName("Nick")
            public String nick;
        }

        @NoArgsConstructor
        @Data
        public static class ImagesDTO {
            @SerializedName("FileId")
            public long fileId;
            @SerializedName("FileMd5")
            public String fileMd5;
            @SerializedName("FileSize")
            public int fileSize;
        }
    }
}
