# PepperBotPlugin

一个基于OPQBot&Bukkit的QQ机器人插件 _（半成品）_

## 功能

1. 聊天互通：转发游戏内消息到QQ群&转发QQ群消息到游戏（暂时仅支持TrChat）
2. 关键词回复：检测到群内关键词，回复对应信息
3. ~~入群欢迎：检测到入群自动欢迎(暂时无法@进群者)~~
4. 执行命令：如果被设置为管理员，可设置QQ群内设置自动回复
5. API：将本插件作为依赖，可使用'AsyncQQMessageEvent'等事件监听聊天信息，使用'sendQQMessage'方法来发送信息(具体参考[OPQAPI](https://apifox.com/apidoc/shared-72cecf14-815e-4238-82a5-6c68d006fd00) )

## 注意事项

1. 使用OPQBot这个闭源项目，请各位自行斟酌！
2. 功能暂不完善，欢迎各位PR/Issue！

## 使用方法
1. 安装插件
2. 运行OPQBot（项目地址:[OPQ](https://github.com/opq-osc/OPQ) [OPQAPI](https://apifox.com/apidoc/shared-72cecf14-815e-4238-82a5-6c68d006fd00)）
