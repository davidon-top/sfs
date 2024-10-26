## $ whoami

SFS full name ScalaFullStack is a collection of libraries to make full stack development in scala easy and composable

## Features

This project is far from being ready to use so for now these also include planned features for 1.0

- [X] SSR support
- [X] CSR support
- [ ] Hydration
- [ ] router
- [ ] zio server integration
- [ ] http4s server integration

### TODO

- [ ] Type safety, eliminate ? as generic param and asInstanceOf where possible
- [ ] other server integrations

## Packages

- sfs - different renderers (String, dom, hydration) and reactivity bindings and router
- dom - shared jvm/js html builder which includes: tags, attributes, props, svg, utils
    - possible to use from other libraries which need a js+jvm html/dom builder
- integrations/* - various server integrations