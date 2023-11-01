# react-native-video360

This package will let you play 360 videos. This module to play 360 videos, using the SGPlayer for iOS, and Google VR for Android.

## Installation

```sh
npm install react-native-video360
```

## Note
If you want to run it on simulator or vise-versa 

Go to node_modules/react-native-video360/react-native-video360.podspec and update as below

Simulator 
```
# dev simulator
s.ios.vendored_frameworks = 'Frameworks/SGPlayer.framework','Frameworks/SGPlatform.framework'
 # production
 #s.ios.vendored_frameworks = 'Frameworks/arm/SGPlayer.framework','Frameworks/arm/SGPlatform.framework'
```

Device
```
# dev simulator
#s.ios.vendored_frameworks = 'Frameworks/SGPlayer.framework','Frameworks/SGPlatform.framework'
 # production
s.ios.vendored_frameworks = 'Frameworks/arm/SGPlayer.framework','Frameworks/arm/SGPlatform.framework'
```

If you are using the example just change react-native-video360.podspec and uncomment the lines as above

## Usage

```js
import { StyleSheet, Modal } from 'react-native';
import {Video360Mode, Video360Player} from 'react-native-video360';

// ...

<Video360Player style={{flex: 1}} urlVideo={''} modeVideo={Video360Mode.AVPlayerVR}/>
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
