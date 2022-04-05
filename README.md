<h1 align="center">
  <br>
    spring4shell_victim
  <br>
  <br>
</h1>

<h4 align="center">Intentionally vulnerable Spring app to test CVE-2022-22965</h4>
<p align="center">
  <a href="https://twitter.com/fracturelabs"><img src="https://img.shields.io/badge/twitter-%40fracturelabs-orange.svg" alt="@fracturelabs" height="18"></a>
  <a href="https://twitter.com/brkr19"><img src="https://img.shields.io/badge/twitter-%40brkr19-orange.svg" alt="@brkr19" height="18"></a>
</p>
<br>

# Usage

## Build
```bash
git clone https://github.com/fracturelabs/spring4shell_victim.git
cd spring4shell_victim
docker image build -t spring4shell_victim .
```

## Run
```bash
docker container run -it -p 8080:8080 --name spring4shell_victim --rm spring4shell_victim
```

## Exploit
There are two routes defined: `/spring4shell_victim` and `/spring4shell_victim/vulnerable`. You can use this to verify any scanning tools are properly working. The default route (/) is specifically not vulnerable to get you to think about how to configure your scanning tools to find vulnerable endpoints.

### Example
```bash
# Default route is not vulnerable
curl -is localhost:9000/spring4shell_victim/?class.module.classLoader.URLs%5b-1%5d

# This route is vulnerable
curl -is localhost:9000/spring4shell_victim/vulnerable?class.module.classLoader.URLs%5b-1%5d
```

![screenshot](https://user-images.githubusercontent.com/8271279/161859867-718f165a-6cca-4582-87f8-f6fc8d7bc56a.png)

### Verification
You can verify your code deployed correctly by connecting to a shell on the container and looking in the `/usr/local/tomcat/webapps/` directory.
```bash
docker exec -it spring4shell_victim /bin/bash
```
NOTE: The POC code above only causes a crash that you can detect (500 error). It does not actually upload any code.

