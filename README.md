# toymaker

## usage
```gradle
repositories {
  maven {
    name = "Modding Playground Maven"
    url  = "https://raw.githubusercontent.com/moddingplayground/maven/main/"
  }
}

dependencies {
  modImplementation "net.moddingplayground.toymaker:toymaker-fabric:${TOYMAKER VERSION}"
  include           "net.moddingplayground.toymaker:toymaker-fabric:${TOYMAKER VERSION}"
}
```

## license
This project's code is licensed under [MIT](LICENSE). If you would like clarification or explicit permission, contact us on [Discord](https://discord.moddingplayground.net).
