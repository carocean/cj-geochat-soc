# 社会关系
> 管理和维护用户的社会关系，包括：通讯录、群、地理群、现实、广播、圈子等，这些统一抽象为Channel。  
> 反过来说：用于管理和维护频道的明确成员。
> 
# 配置
> 采用maven发布： mvn clean deploy -P release  
> 发布后会自动生成docker镜像： geochat/social:1.0.0  
> 根据镜像和dockerFile文件，可在docker&docker-compose&k8s中部署  

# 依赖
> 该项目为imc（消息中心提供社交关系查询服务）