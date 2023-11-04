# react-native-video360

This package will let you play 360 videos. This module to play 360 videos, using the SGPlayer for iOS, and Google VR for Android.

## Installation

```sh
npm install react-native-video360
```

## iOS Usage

If you want to run it on simulator 

Go to node_modules/react-native-video360/react-native-video360.podspec and update as below

For Simulator 
```
# dev simulator
s.ios.vendored_frameworks = 'Frameworks/SGPlayer.framework','Frameworks/SGPlatform.framework'
 # production
 #s.ios.vendored_frameworks = 'Frameworks/arm/SGPlayer.framework','Frameworks/arm/SGPlatform.framework'
```
Note for ios simulator:

Open your ios project with Xcode and Go to build settings > excluded architecture > Debug > Any ios simulator SDK = 'arm64'

For Device
```
# dev simulator
#s.ios.vendored_frameworks = 'Frameworks/SGPlayer.framework','Frameworks/SGPlatform.framework'
 # production
s.ios.vendored_frameworks = 'Frameworks/arm/SGPlayer.framework','Frameworks/arm/SGPlatform.framework'
```

If you are using the example just change react-native-video360.podspec and uncomment the lines as above


Note: Dont forget to pod install again

```js
import { StyleSheet, Modal } from 'react-native';
import {Video360Mode, Video360Player} from 'react-native-video360';

// ...

<Video360Player style={{flex: 1}} urlVideo={''} modeVideo={Video360Mode.AVPlayerVR}/>
```


## Android Usage

```js
import { StyleSheet, Modal } from 'react-native';
import {Video360Mode, Video360Player} from 'react-native-video360';

// ...

<Video360Player style={{flex: 1}} urlVideo={''} modeVideo={Video360Mode.AVPlayerVR}/>
```

Android supports following props too.

```
volume={1}
displayMode='embedded'
enableInfoButton={true}
enableFullscreenButton={true}
enableCardboardButton={true}
enableTouchTracking={true}
hidesTransitionView={false}
```


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
