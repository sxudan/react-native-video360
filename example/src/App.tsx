import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { Video360Mode, Video360Player } from 'react-native-video360';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          component={Home}
          name="Home"
          options={{ orientation: 'landscape_left', headerShown: false }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

function Home() {
  const [mode, setMode] = React.useState(Video360Mode.AVPlayerVRBox);

  return (
    <View style={{ flex: 1 }}>
      <Video360Player
        style={{ flex: 1 }}
        urlVideo={
          'https://agriknow-development-assets.s3.ap-southeast-2.amazonaws.com/2041337d-08ed-4f9b-ae4a-dc6046e70abe.mp4'
        }
        modeVideo={mode}
      />
      <TouchableOpacity
        style={styles.switchButton}
        onPress={() => {
          if (mode == Video360Mode.AVPlayerVR) {
            setMode(Video360Mode.AVPlayerVRBox);
          } else {
            setMode(Video360Mode.AVPlayerVR);
          }
        }}
      >
        <Text>Click</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  switchButton: {
    position: 'absolute',
    top: 44,
    left: 44,
    width: 100,
    height: 55,
    backgroundColor: 'red',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  },
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
