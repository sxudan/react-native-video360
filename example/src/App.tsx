import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator, } from '@react-navigation/native-stack';
import { StyleSheet } from 'react-native';
import {Video360Mode, Video360Player} from 'react-native-video360';

const Stack = createNativeStackNavigator();

export default function App() {

  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen component={Home} name='Home' options={{orientation: 'landscape_left', headerShown: false}}/>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

function Home() {

  return (
    <Video360Player style={{flex: 1}} urlVideo={''} modeVideo={Video360Mode.AVPlayerVR}/>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
