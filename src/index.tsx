import { requireNativeComponent } from 'react-native';
import React from 'react';
// const LINKING_ERROR =
//   `The package 'react-native-video360' doesn't seem to be linked. Make sure: \n\n` +
//   Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
//   '- You rebuilt the app after installing the package\n' +
//   '- You are not using Expo Go\n';


// const Video360 = NativeModules.Video360
//   ? NativeModules.Video360
//   : new Proxy(
//       {},
//       {
//         get() {
//           throw new Error(LINKING_ERROR);
//         },
//       }
//     );


// function multiply(a: number, b: number): Promise<number> {
//   return Video360.multiply(a, b);
// }



const Video360 = requireNativeComponent('Video360');


export enum Video360Mode {
  AVPlayerVR = 1, // 360
  AVPlayerVRBox = 2, // 360 with glasses
  AVPlayerNormal = 3, // normal
}

export interface Video360Props {
  urlVideo: string
  modeVideo: number
  style?: {
    width?: number
    height?: number
    flex?: number
  }
  volume?: number
  displayMode?:string
  enableInfoButton?:boolean
  enableFullscreenButton?:boolean
  enableCardboardButton?:boolean
  enableTouchTracking?:boolean
  hidesTransitionView?: boolean
}

export const Video360Player = (props: Video360Props) => {
  return <Video360 {...props}/>
}
