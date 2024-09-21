## $ whoami

SFS full name ScalaFullStack is a collection of libraries to make full stack development in scala easy and composable

## Features

This project is far from being ready to use so for now these also include planned features for 1.0

- [X] SSR support
- [ ] CSR support
- [ ] Hydration
- [ ] router
- [ ] RPC integration or server functions
- [ ] ReScala reactive backend
- [ ] zio server integration

### TODO

- [ ] Full type safety, eliminate ? as generic param and asInstanceOf where possible
- [ ] AirStream reactive backend
- [ ] other server integrations

## Packages

- sfs - different renderers (String, dom, hydration) and reactivity bindings
- dom - shared jvm/js html builder which includes: tags, attributes, props, svg utils
    - possible to use from other libraries which need a js+jvm html/dom builder