#!/bin/sh
cp patches/react-native-video360-dev.podspec node_modules/react-native-video360plugin/react-native-video360.podspec
cd ios
pod install
cd ..
