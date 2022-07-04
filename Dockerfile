FROM gradle:7.4.2-jdk11
COPY . /gradle/project
# вместо . надо путь на root
WORKDIR /gradle/project
EXPOSE 8080
ENTRYPOINT ["gradle"]
CMD ["bootRun"]


