import * as React from 'react';

import { StyleSheet, View, Text, Modal } from 'react-native';
import {Video360Mode, Video360Player} from 'react-native-video360';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  // React.useEffect(() => {
  //   multiply(3, 7).then(setResult);
  // }, []);

  return (
    <Modal style={styles.container}>
      <Video360Player style={{flex: 1}} urlVideo={'https://agriknow-development-assets.s3.ap-southeast-2.amazonaws.com/2041337d-08ed-4f9b-ae4a-dc6046e70abe.mp4'} modeVideo={Video360Mode.AVPlayerVR}/>
    </Modal>
  );
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
