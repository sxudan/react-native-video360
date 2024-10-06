import { requireNativeComponent } from 'react-native';
import React from 'react';
const Video360 = requireNativeComponent('Video360');

export enum Video360Mode {
  AVPlayerVR = 1, // 360
  AVPlayerVRBox = 2, // 360 with glasses
  AVPlayerNormal = 3, // normal
}

export interface Video360Props {
  urlVideo: string;
  modeVideo: number;
  style?: {
    width?: number;
    height?: number;
    flex?: number;
  };
  volume?: number;
  displayMode?: string;
  enableInfoButton?: boolean;
  enableFullscreenButton?: boolean;
  enableCardboardButton?: boolean;
  enableTouchTracking?: boolean;
  hidesTransitionView?: boolean;
}

export const Video360Player = (props: Video360Props) => {
  return <Video360 {...props} />;
};
